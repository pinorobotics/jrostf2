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
package pinorobotics.jrostf2.tf2_msgs;

import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for tf2_msgs/TF2Error */
@MessageMetadata(
        name = TF2ErrorMessage.NAME,
        fields = {"error", "error_string"},
        md5sum = "bc6848fd6fd750c92e38575618a4917d")
public class TF2ErrorMessage implements Message {

    static final String NAME = "tf2_msgs/TF2Error";

    public enum ErrorType {
        NO_ERROR,
        LOOKUP_ERROR,
        CONNECTIVITY_ERROR,
        EXTRAPOLATION_ERROR,
        INVALID_ARGUMENT_ERROR,
        TIMEOUT_ERROR,
        TRANSFORM_ERROR,
    }

    public byte error;

    public StringMessage error_string = new StringMessage();

    public TF2ErrorMessage withError(ErrorType error) {
        this.error = (byte) error.ordinal();
        return this;
    }

    public TF2ErrorMessage withErrorString(StringMessage error_string) {
        this.error_string = error_string;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(error, error_string);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (TF2ErrorMessage) obj;
        return error == other.error && Objects.equals(error_string, other.error_string);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "error", error,
                "error_string", error_string);
    }

    public ErrorType getCodeType() {
        return ErrorType.values()[error];
    }

    public boolean isOk() {
        return getCodeType() == ErrorType.NO_ERROR;
    }
}
