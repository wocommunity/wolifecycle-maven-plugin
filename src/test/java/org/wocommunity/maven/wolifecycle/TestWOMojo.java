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

import org.wocommunity.maven.wolifecycle.AbstractWOMojo;

import junit.framework.TestCase;

public class TestWOMojo extends TestCase {

    protected AbstractWOMojo mojo;

    @Override
    protected void setUp() throws Exception {
	super.setUp();

	mojo = new MockWOMojo();
    }

    public void testIsNotWebObjectsGroup() throws Exception {
	String group = "another.group";

	assertFalse(mojo.isWebObjectAppleGroup(group));
    }

    public void testIsNullGroup() throws Exception {
	assertFalse(mojo.isWebObjectAppleGroup(null));
    }

    public void testWebObjectsGroupIsOsIndependent() throws Exception {
	String group = "com.webobjects";

	assertTrue(mojo.isWebObjectAppleGroup(group));
    }

}
