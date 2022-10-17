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
package pinorobotics.jrostf2.tests;

import id.jros1client.JRos1Client;
import id.jros1client.JRos1ClientFactory;
import id.xfunction.ResourceUtils;
import id.xfunction.XJson;
import id.xfunction.logging.XLogger;
import id.xfunction.text.WildcardMatcher;
import java.net.MalformedURLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pinorobotics.jrostf2.JRosTf2;

public class JRosTf2IntegrationTests {

    private static final ResourceUtils resourceUtils = new ResourceUtils();

    private static JRos1Client client;
    private JRosTf2 tf2;

    @BeforeAll
    public static void setupAll() {
        XLogger.load("jrostf2-test.properties");
    }

    @BeforeEach
    public void setup() throws MalformedURLException {
        XJson.setLimitDecimalPlaces(3);
        client = new JRos1ClientFactory().createClient();
        tf2 = new JRosTf2(client);
    }

    @AfterEach
    public void clean() throws Exception {
        tf2.close();
        client.close();
    }

    @Test
    public void test_lookupTransform() throws Exception {
        var result = tf2.lookupTransform("world", "panda_hand");
        System.out.println(result);
        Assertions.assertTrue(
                new WildcardMatcher(resourceUtils.readResource("panda_hand"))
                        .matches(result.toString()));
    }
}
