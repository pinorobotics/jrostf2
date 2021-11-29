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
/*
 * Authors:
 * - aeon_flux <aeon_flux@eclipso.ch>
 */
package pinorobotics.jrostf2;

import java.io.Closeable;
import java.io.IOException;

import id.jrosclient.JRosClient;
import id.jrosmessages.primitives.Duration;
import id.xfunction.logging.XLogger;
import pinorobotics.jrosactionlib.JRosActionClient;
import pinorobotics.jrostf2.exceptions.JRosTf2Exception;
import pinorobotics.jrostf2.tf2_msgs.LookupTransformActionDefinition;
import pinorobotics.jrostf2.tf2_msgs.LookupTransformGoalMessage;
import pinorobotics.jrostf2.tf2_msgs.LookupTransformResultMessage;
import pinorobotics.jrostf2.tf2_msgs.TF2ErrorMessage;

/**
 * Client which allows to interact with ROS TF2 Buffer Server.
 * 
 * <p>TF2 Buffer Server is part of TF2 package and can be started using:
 * 
 * <pre>
 * rosrun tf2_ros buffer_server
 * </pre>
 * 
 */
public class JRosTf2 implements Closeable {

    private static final String TF2_BUFFER_SERVER_NAME = "/tf2_buffer_server";
    private static final XLogger LOGGER = XLogger.getLogger(JRosTf2.class);
    private JRosActionClient<LookupTransformGoalMessage, LookupTransformResultMessage> lookupTransformActionClient;

    private LookupTransformGoalMessage goal = new LookupTransformGoalMessage()
            .withTimeout(new Duration(1));
    
    /**
     * Creates a new instance of the client which will interact with TF2 Buffer Server
     * {@link JRosTf2#TF2_BUFFER_SERVER_NAME}
     * @param client ROS client
     */
    public JRosTf2(JRosClient client) {
        this(client, TF2_BUFFER_SERVER_NAME);
    }
    
    /**
     * Creates a new instance of the client
     * @param client ROS client
     * @param name of buffer action server
     */
    public JRosTf2(JRosClient client, String actionServerName) {
        lookupTransformActionClient = new JRosActionClient<>(
                client, new LookupTransformActionDefinition(), actionServerName);
    }
    
    /**
     * Request Buffer Server to calculate lookup transformation from source to target frame
     * @throws JRosTf2Exception 
     */
    public LookupTransformResultMessage lookupTransform(String targetFrameId, String sourceFrameId) throws JRosTf2Exception {
        LOGGER.entering("lookupTransform");
        LookupTransformResultMessage result;
        goal.source_frame.data = sourceFrameId;
        goal.target_frame.data = targetFrameId;
        try {
            result = lookupTransformActionClient.sendGoal(goal).get();
        } catch (Exception e) {
            throw new JRosTf2Exception(e);
        }
        verifyResult(result.error);
        LOGGER.exiting("plan", result);
        return result;
    }

    @Override
    public void close() throws IOException {
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
