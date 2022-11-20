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
package pinorobotics.jrostf2;

import id.jrosmessages.Message;
import pinorobotics.jrostf2.exceptions.JRosTf2Exception;

/**
 * Base interface which describes client to interact with ROS TF2 Buffer Server.
 *
 * @author aeon_flux aeon_flux@eclipso.ch
 */
public interface JRosTf2<R extends Message> extends AutoCloseable {

    /** Request Buffer Server to calculate lookup transformation from source to target frame */
    R lookupTransform(String targetFrameId, String sourceFrameId) throws JRosTf2Exception;
}
