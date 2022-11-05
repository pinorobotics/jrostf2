/*
 * Copyright 2022 jrostf2 project
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
import pinorobotics.jrostf2.tf2_msgs.TF2ErrorMessage;

/**
 * @author aeon_flux aeon_flux@eclipso.ch
 */
public interface LookupTransformResult extends Message {
    TF2ErrorMessage getError();
}
