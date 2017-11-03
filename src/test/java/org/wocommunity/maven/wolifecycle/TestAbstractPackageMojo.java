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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.Before;
import org.junit.Test;
import org.wocommunity.maven.wolifecycle.AbstractPackageMojo;

public class TestAbstractPackageMojo extends AbstractMojoTestCase {

    private static final File TEST_POM = new File(getBasedir(),
	    "src/test/resources/unit/wolifecycle-basic-test/pom.xml");

    protected AbstractPackageMojo mojo;

    @Override
    @Before
    protected void setUp() throws Exception {
	super.setUp();

	mojo = (AbstractPackageMojo) lookupMojo("package-woapplication",
		TEST_POM);
    }

    @Test
    public void testClassifierAsString() throws Exception {
	assertThat(mojo.getClassifierAsString(), is("-someClassifier"));
    }

    @Test
    public void testFinalNameWithClassifier() throws Exception {
	assertThat(mojo.getArtifactFile().getName(),
		is("foo-1.0-SNAPSHOT-someClassifier.woapplication"));
    }

    @Test
    public void testFinalNameWithEmptyClassifier() throws Exception {
	mojo.setClassifier(null);

	assertThat(mojo.getArtifactFile().getName(),
		is("foo-1.0-SNAPSHOT.woapplication"));
    }

    @Test
    public void testNullClassifierAsString() throws Exception {
	mojo.setClassifier(null);

	assertThat(mojo.getClassifierAsString(), is(""));
    }
}
