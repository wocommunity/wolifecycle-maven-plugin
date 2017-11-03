/**
 * Copyright (C) 2001 WOCommunity <contact@wocommunity.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.wocommunity.maven.wolifecycle;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import java.io.File;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.Before;
import org.junit.Test;
import org.wocommunity.maven.wolifecycle.DefineWOApplicationResourcesMojo;

public class TestDefineWOApplicationResourcesMojo extends AbstractMojoTestCase {
    private static final File TEST_POM = new File(getBasedir(),
	    "src/test/resources/unit/wolifecycle-basic-test/pom.xml");

    DefineWOApplicationResourcesMojo mojo;

    @Override
    @Before
    protected void setUp() throws Exception {
	super.setUp();

	mojo = (DefineWOApplicationResourcesMojo) lookupMojo(
		"define-woapplication-resources", TEST_POM);
    }

    @Test
    public void testDefaultFrameworksFolder() throws Exception {
	mojo.setClassifier(null);

	File folder = mojo.getFrameworksFolder();

	assertThat(folder.getAbsolutePath(),
		containsString("foo-1.0-SNAPSHOT.woa/Contents/Frameworks"));
    }

    @Test
    public void testFrameworksFolderWithClassifier() throws Exception {
	File folder = mojo.getFrameworksFolder();

	assertThat(
		folder.getAbsolutePath(),
		containsString("foo-1.0-SNAPSHOT-someClassifier.woa/Contents/Frameworks"));
    }

    @Test
    public void testFrameworksFolderWithFinalName() throws Exception {
	mojo.setFinalName("foo-bar-name");
	mojo.setClassifier(null);

	File folder = mojo.getFrameworksFolder();

	assertThat(folder.getAbsolutePath(),
		containsString("foo-bar-name.woa/Contents/Frameworks"));
    }

    @Test
    public void testNormalizedFilePath() throws Exception {
	String path = "C:\\Documents and Settings\\User\\.m2\\repository";

	String result = DefineWOApplicationResourcesMojo.normalizedPath(path);

	assertEquals("C:/Documents and Settings/User/.m2/repository", result);
    }
}
