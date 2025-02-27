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
package org.openrewrite.gradle.marker;

import lombok.Value;
import org.openrewrite.internal.lang.Nullable;

@Value
public class GradlePluginDescriptor {
    /**
     * The fully qualified name of the class which implements the plugin.
     */
    String fullyQualifiedClassName;

    /**
     * The ID by which a plugin can be applied in the plugins{} block. Not all Gradle plugins have an ID, including
     * script plugins, or plugins which are implementation details of other plugins.
     */
    @Nullable
    String id;
}
