/*
 * Copyright 2022 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openrewrite.maven;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.maven.Assertions.pomXml;

public class ChangePackagingTest implements RewriteTest {

    @Test
    void addPackaging() {
        rewriteRun(
          spec -> spec.recipe(new ChangePackaging("*", "*", "pom")),
          pomXml(
"""
              <project>
                  <groupId>org.example</groupId>
                  <artifactId>foo</artifactId>
                  <version>1.0</version>
              </project>
              """,
            """
              <project>
                  <groupId>org.example</groupId>
                  <artifactId>foo</artifactId>
                  <version>1.0</version>
                  <packaging>pom</packaging>
              </project>
              """
          )
        );
    }

    @Test
    void removePackaging() {
        rewriteRun(
          spec -> spec.recipe(new ChangePackaging("*", "*", null)),
          pomXml(
"""
              <project>
                  <groupId>org.example</groupId>
                  <artifactId>foo</artifactId>
                  <version>1.0</version>
                  <packaging>pom</packaging>
              </project>
              """,
            """
              <project>
                  <groupId>org.example</groupId>
                  <artifactId>foo</artifactId>
                  <version>1.0</version>
              </project>
              """
          )
        );
    }

    @Test
    void changePackaging() {
        rewriteRun(
          spec -> spec.recipe(new ChangePackaging("*", "*", "pom")),
          pomXml(
"""
              <project>
                  <groupId>org.example</groupId>
                  <artifactId>foo</artifactId>
                  <version>1.0</version>
                  <packaging>jar</packaging>
              </project>
              """,
            """
              <project>
                  <groupId>org.example</groupId>
                  <artifactId>foo</artifactId>
                  <version>1.0</version>
                  <packaging>pom</packaging>
              </project>
              """
          )
        );
    }
}
