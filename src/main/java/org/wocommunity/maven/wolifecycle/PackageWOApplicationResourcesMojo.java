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
import java.io.File;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.artifact.handler.DefaultArtifactHandler;
import org.apache.maven.artifact.versioning.VersionRange;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

/**
 * resources goal for WebObjects projects.
 * 
 * @goal package-woapplication
 * @phase package
 * @requiresProject
 * @requiresDependencyResolution compile
 * @threadSafe
 * @author uli
 * @author hprange
 * @since 2.0
 */
public class PackageWOApplicationResourcesMojo extends AbstractPackageMojo {

    /**
     * The maven project.
     *
     * @parameter property="project"
     * @required
     * @readonly
     */
    private MavenProject project;

    public PackageWOApplicationResourcesMojo() {
	super();
    }

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
	super.execute();

	File woapplicationFile = getWOApplicationFile();

	getLog().info("Setting primary artifact: "
		+ woapplicationFile.getAbsolutePath());

	DefaultArtifactHandler artifactHandler = new DefaultArtifactHandler(
		"woapplication.tar.gz");
	DefaultArtifact artifact = new DefaultArtifact(project.getGroupId(),
		project.getArtifactId(),
		VersionRange.createFromVersion(project.getVersion()),
		Artifact.SCOPE_RUNTIME, "woapplication.tar.gz", getClassifier(),
		artifactHandler);

	artifact.setFile(woapplicationFile);
	project.setArtifact(artifact);

	File webServerResourcesArtifactFile = getWOWebServerResourcesArtifactFile();

	getLog().info("Attaching artifact: "
		+ webServerResourcesArtifactFile.getAbsolutePath());

	getProjectHelper().attachArtifact(project,
		"wowebserverresources.tar.gz", getClassifier(),
		webServerResourcesArtifactFile);
    }

    @Override
    public String getProductExtension() {
	return "woapplication";
    }

    @Override
    public MavenProject getProject() {
	return project;
    }

    protected File getWOApplicationFile() {
	return new File(getBuildDirectory(),
		getFinalName() + ".woapplication.tar.gz");
    }

    private File getWOWebServerResourcesArtifactFile() {
	return new File(getBuildDirectory(),
		getFinalName() + ".wowebserverresources.tar.gz");
    }
}
