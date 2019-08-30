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

// org.apache.maven.plugins:maven-compiler-plugin:compile
import java.io.File;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProjectHelper;

public abstract class AbstractPackageMojo extends AbstractWOMojo {
    /**
     * @component
     */
    private MavenProjectHelper projectHelper;

    public AbstractPackageMojo() {
	super();
    }

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
	getLog().info("Packaging WebObjects project");

	getProject().getArtifact().setFile(getArtifactFile());
    }

    protected File getArtifactFile() {
	return new File(getBuildDirectory(), getFinalName()
		+ getClassifierAsString() + "." + getProductExtension());
    }

    public MavenProjectHelper getProjectHelper() {
	return projectHelper;
    }

    public void setProjectHelper(final MavenProjectHelper projectHelper) {
	this.projectHelper = projectHelper;
    }
}
