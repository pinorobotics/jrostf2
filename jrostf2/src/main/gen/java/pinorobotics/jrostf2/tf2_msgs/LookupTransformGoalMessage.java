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
import id.jrosmessages.primitives.Duration;
import id.jrosmessages.primitives.Time;
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for tf2_msgs/LookupTransformGoal */
@MessageMetadata(
        name = LookupTransformGoalMessage.NAME,
        md5sum = "35e3720468131d675a18bb6f3e5f22f8")
public class LookupTransformGoalMessage implements Message {

    static final String NAME = "tf2_msgs/LookupTransformGoal";

    /** Simple API */
    public StringMessage target_frame = new StringMessage();

    public StringMessage source_frame = new StringMessage();

    public Time source_time = new Time();

    public Duration timeout = new Duration();

    /** Advanced API */
    public Time target_time = new Time();

    public StringMessage fixed_frame = new StringMessage();

    /** Whether or not to use the advanced API */
    public boolean advanced;

    public LookupTransformGoalMessage withTargetFrame(StringMessage target_frame) {
        this.target_frame = target_frame;
        return this;
    }

    public LookupTransformGoalMessage withSourceFrame(StringMessage source_frame) {
        this.source_frame = source_frame;
        return this;
    }

    public LookupTransformGoalMessage withSourceTime(Time source_time) {
        this.source_time = source_time;
        return this;
    }

    public LookupTransformGoalMessage withTimeout(Duration timeout) {
        this.timeout = timeout;
        return this;
    }

    public LookupTransformGoalMessage withTargetTime(Time target_time) {
        this.target_time = target_time;
        return this;
    }

    public LookupTransformGoalMessage withFixedFrame(StringMessage fixed_frame) {
        this.fixed_frame = fixed_frame;
        return this;
    }

    public LookupTransformGoalMessage withAdvanced(boolean advanced) {
        this.advanced = advanced;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                target_frame,
                source_frame,
                source_time,
                timeout,
                target_time,
                fixed_frame,
                advanced);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (LookupTransformGoalMessage) obj;
        return Objects.equals(target_frame, other.target_frame)
                && Objects.equals(source_frame, other.source_frame)
                && Objects.equals(source_time, other.source_time)
                && Objects.equals(timeout, other.timeout)
                && Objects.equals(target_time, other.target_time)
                && Objects.equals(fixed_frame, other.fixed_frame)
                && advanced == other.advanced;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "target_frame", target_frame,
                "source_frame", source_frame,
                "source_time", source_time,
                "timeout", timeout,
                "target_time", target_time,
                "fixed_frame", fixed_frame,
                "advanced", advanced);
    }
}
