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

//org.apache.maven.plugins:maven-compiler-plugin:compile
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

/**
 * resources goal for WebObjects projects.
 * 
 * @goal define-woframework-resources
 * @threadSafe
 * @author uli
 * @since 2.0
 */
public class DefineWOFrameworkResourcesMojo extends AbstractDefineResourcesMojo {

    /**
     * The maven project.
     *
     * @parameter property="project"
     * @required
     * @readonly
     */
    private MavenProject project;

    /**
     * Read patternsets.
     *
     * @parameter property="readPatternsets"
     */
    private Boolean readPatternsets;

    public DefineWOFrameworkResourcesMojo() {
	super();
    }

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
	super.execute();
    }

    @Override
    public MavenProject getProject() {
	return project;
    }

    @Override
    public String getProductExtension() {
	return "framework";
    }

    @Override
    public boolean hasContentsFolder() {
	return false;
    }

    @Override
    protected Boolean readPatternsets() {
	return readPatternsets;
    }

    @Override
    public boolean includesVersionInArtifactName() {
	return false;
    }
}
