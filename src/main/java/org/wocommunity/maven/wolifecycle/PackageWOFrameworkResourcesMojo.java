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
import org.apache.maven.project.MavenProject;

/**
 * resources goal for WebObjects projects.
 * 
 * @goal package-woframework
 * @phase package
 * @requiresProject
 * @requiresDependencyResolution compile
 * @author uli
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 * @since 2.0
 */
public class PackageWOFrameworkResourcesMojo extends AbstractPackageMojo {

    /**
     * The maven project.
     *
     * @parameter property="project"
     * @required
     * @readonly
     */
    private MavenProject project;

    public PackageWOFrameworkResourcesMojo() {
	super();
    }

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
	super.execute();
    }

    @Override
    public String getProductExtension() {
	return "jar";
    }

    @Override
    public MavenProject getProject() {
	return project;
    }

    protected File getWOFrameworkFile() {
	return new File(getBuildDirectory(), getFinalName() + ".jar");
    }
}
