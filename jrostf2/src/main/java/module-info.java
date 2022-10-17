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
/**
 * Java module which allows to interact with <a href="http://wiki.ros.org/tf2">TF2</a> in ROS
 * (Robotic Operation System).
 *
 * @see <a href="https://github.com/pinorobotics/jrostf2/releases">Download</a>
 * @see <a href="https://github.com/pinorobotics/jrostf2">GitHub repository</a>
 * @see <a href="http://wiki.ros.org/tf/Tutorials">TF Tutorial</a>
 * @see <a href="http://wiki.ros.org/tf2/Tutorials">TF2 Tutorial</a>
 * @see <a href="https://www.youtube.com/watch?v=Xf25dVrG5ks">Transformations explained</a>
 * @author aeon_flux aeon_flux@eclipso.ch
 */
module jrostf2 {

    // since many of our API relies on jrosclient and jrosactionlib
    // classes we need to ensure that all modules reading this module
    // also read them
    requires transitive jros1client;
    requires transitive jros1actionlib;
    requires transitive jros1messages;
    requires id.xfunction;

    exports pinorobotics.jrostf2;
    exports pinorobotics.jrostf2.tf2_msgs;
}
