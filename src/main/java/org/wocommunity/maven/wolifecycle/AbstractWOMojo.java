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

import java.io.File;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.project.MavenProject;

public abstract class AbstractWOMojo extends AbstractMojo {

    public final static String MAVEN_WEBOBJECTS_GROUP_ID = "com.webobjects";

    /**
     * @parameter property="project.build.directory"
     * @required
     * @readonly
     */
    private File buildDirectory;

    /**
     * Classifier to add to the artifact generated. If given, the artifact will
     * be an attachment instead.
     * 
     * @parameter
     */
    private String classifier;

    /**
     * The set of dependencies required by the project
     * 
     * @parameter default-value="${project.dependencies}"
     * @required
     * @readonly
     */
    private List<Artifact> dependencies;

    /**
     * The name of the generated package (framework or application).
     *
     * @parameter property="project.build.finalName"
     * @required
     */
    private String finalName;

    /**
     * @parameter property="localRepository"
     * @required
     * @readonly
     */
    private ArtifactRepository localRepository;

    /**
     * The maven project.
     *
     * @parameter property="project"
     * @required
     * @readonly
     */
    private MavenProject project;

    public AbstractWOMojo() {
	super();
    }

    public File getBuildDirectory() {
	return buildDirectory;
    }

    public String getClassifier() {

	return classifier;
    }

    protected String getClassifierAsString() {
	return getClassifier() == null ? "" : "-" + getClassifier();
    }

    public List<Artifact> getDependencies() {
	return dependencies;
    }

    public String getFinalName() {
	return finalName;
    }

    public ArtifactRepository getLocalRepository() {
	return localRepository;
    }

    public abstract String getProductExtension();

    public MavenProject getProject() {
	return project;
    }

    protected File getProjectFolder() {
	return getProject().getBasedir();
    }

    protected File getWOProjectFolder() {
	File file = new File(getProjectFolder(), "woproject");

	return file.exists() ? file : null;
    }

    protected boolean isWebObjectAppleGroup(final String dependencyGroup) {
	if (dependencyGroup == null) {
	    return false;
	}

	String normalizedGroup = FilenameUtils
		.separatorsToUnix(dependencyGroup);

	boolean returnValue = MAVEN_WEBOBJECTS_GROUP_ID.equals(normalizedGroup);

	getLog().debug(
		"The group " + normalizedGroup + " is "
			+ (returnValue ? "" : "NOT ") + "an Apple group.");

	return returnValue;
    }

    public void setBuildDirectory(final File buildDirectory) {
	this.buildDirectory = buildDirectory;
    }

    public void setClassifier(final String classifier) {
	this.classifier = classifier;
    }

    public void setFinalName(final String finalName) {
	this.finalName = finalName;
    }
}
