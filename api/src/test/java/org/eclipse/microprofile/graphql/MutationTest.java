/*
 * Copyright (c) 2020 Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eclipse.microprofile.graphql;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * Simple test mainly as a placeholder for now.
 */
public class MutationTest {

    private static class Character {

        private String name;

        public Character(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Mutation("save")
        @Description("Save a character")
        public Character saveCharacter(Character character) {

            return character;
        }
    }

    @Test
    public void testMutationAnnotationOnCharacterMethod() throws Exception {
        Mutation mutation =
                Character.class.getDeclaredMethod("saveCharacter", Character.class).getAnnotation(Mutation.class);
        assertEquals(mutation.value(), "save");
        Description description = Character.class.getDeclaredMethod("saveCharacter", Character.class)
                .getAnnotation(Description.class);
        assertEquals(description.value(), "Save a character");
    }
}
