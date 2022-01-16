/*
 * Copyright 2021 msgmonster project
 * 
 * Website: https://github.com/pinorobotics/msgmonster
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
 * msgmonster autogenerated Message class for jrosclient
 * 
 * Generated for ROS msg file: tf2_msgs/LookupTransformActionGoal
 */

package pinorobotics.jrostf2.tf2_msgs;

import java.util.Objects;

import id.jrosmessages.MessageMetadata;
import id.kineticstreamer.annotations.Streamed;
import id.xfunction.XJson;
import pinorobotics.jrosactionlib.actionlib_msgs.GoalIdMessage;
import pinorobotics.jrosactionlib.msgs.ActionGoalMessage;
import id.jrosmessages.std_msgs.HeaderMessage;

/**
 * Definition for tf2_msgs/LookupTransformActionGoal
 */
@MessageMetadata(
    type = LookupTransformActionGoalMessage.NAME,
    md5sum = "f2e7bcdb75c847978d0351a13e699da5")
public class LookupTransformActionGoalMessage implements ActionGoalMessage<LookupTransformGoalMessage> {
   
   static final String NAME = "tf2_msgs/LookupTransformActionGoal";

   @Streamed
   public HeaderMessage header = new HeaderMessage();
   
   @Streamed
   public GoalIdMessage goal_id = new GoalIdMessage();
   
   @Streamed
   public LookupTransformGoalMessage goal = new LookupTransformGoalMessage();
   
   public LookupTransformActionGoalMessage withHeader(HeaderMessage header) {
       this.header = header;
       return this;
   }
   
   public LookupTransformActionGoalMessage withGoalId(GoalIdMessage goal_id) {
       this.goal_id = goal_id;
       return this;
   }
   
   public LookupTransformActionGoalMessage withGoal(LookupTransformGoalMessage goal) {
       this.goal = goal;
       return this;
   }
   
   @Override
   public int hashCode() {
       return Objects.hash(
           header,
           goal_id,
           goal
       );
   }
   
   @Override
   public boolean equals(Object obj) {
       var other = (LookupTransformActionGoalMessage) obj;
       return
           Objects.equals(header, other.header) &&
           Objects.equals(goal_id, other.goal_id) &&
           Objects.equals(goal, other.goal)
       ;
   }
   
   @Override
   public String toString() {
       return XJson.asString(
           "header", header,
           "goal_id", goal_id,
           "goal", goal
       );
   }
   
}