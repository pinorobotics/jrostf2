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
package pinorobotics.jrostf2.exceptions;

import pinorobotics.jrostf2.tf2_msgs.TF2ErrorMessage;

public class JRosTf2Exception extends Exception {

    private static final long serialVersionUID = 1L;

    public JRosTf2Exception(String fmt, Object... args) {
        super(String.format(fmt, args));
    }

    public JRosTf2Exception(Exception e) {
        super(e);
    }

    public JRosTf2Exception(TF2ErrorMessage code) {
        super(String.format("%s: %s", code.getCodeType(), code.error_string.data));        
    }
}
