/*
 * Copyright 2021 jrostf2 project
 * 
 * Website: https://github.com/pinorobotics/jrostf2
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pinorobotics.jrostf2.impl;

import id.jrosmessages.Message;
import id.jrosmessages.primitives.Duration;
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.logging.XLogger;
import pinorobotics.jrosactionlib.JRosActionClient;
import pinorobotics.jrostf2.JRosTf2;
import pinorobotics.jrostf2.exceptions.JRosTf2Exception;
import pinorobotics.jrostf2.tf2_msgs.LookupTransformGoalMessage;
import pinorobotics.jrostf2.tf2_msgs.TF2ErrorMessage;

/**
 * @author aeon_flux aeon_flux@eclipso.ch
 */
public abstract class AbstractJRosTf2<R extends Message & LookupTransformResult>
        implements JRosTf2<R> {
    private static final XLogger LOGGER = XLogger.getLogger(AbstractJRosTf2.class);
    private JRosActionClient<LookupTransformGoalMessage, R> lookupTransformActionClient;
    private LookupTransformGoalMessage goal =
            new LookupTransformGoalMessage().withTimeout(new Duration(1));

    /** Creates a new instance of the client */
    public AbstractJRosTf2(
            JRosActionClient<LookupTransformGoalMessage, R> lookupTransformActionClient) {
        this.lookupTransformActionClient = lookupTransformActionClient;
    }

    /** Request Buffer Server to calculate lookup transformation from source to target frame */
    @Override
    public R lookupTransform(String targetFrameId, String sourceFrameId) throws JRosTf2Exception {
        LOGGER.entering("lookupTransform");
        goal.withSourceFrame(new StringMessage(sourceFrameId));
        goal.withTargetFrame(new StringMessage(targetFrameId));
        R result;
        try {
            result = lookupTransformActionClient.sendGoalAsync(goal).get();
        } catch (Exception e) {
            throw new JRosTf2Exception(e);
        }
        verifyResult(result.getError());
        LOGGER.exiting("lookupTransform", result);
        return result;
    }

    @Override
    public void close() throws Exception {
        LOGGER.entering("close");
        lookupTransformActionClient.close();
        LOGGER.exiting("close");
    }

    private void verifyResult(TF2ErrorMessage code) throws JRosTf2Exception {
        if (!code.isOk()) {
            throw new JRosTf2Exception(code);
        }
    }
}
