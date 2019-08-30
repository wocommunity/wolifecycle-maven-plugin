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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ulrich
 */
public class PatternsetReader {
    private List<String> pattern = Collections.emptyList();

    public PatternsetReader(final File patternset) throws IOException {

	List<String> patternList = new ArrayList<String>();

	try (FileReader fr = new FileReader(patternset);
             BufferedReader patternReader = new BufferedReader(fr)) {

	    String line = patternReader.readLine();

	    while (line != null) {
		if (line.length() > 0) {
		    patternList.add(line);
		}

		line = patternReader.readLine();
	    }
	}

	pattern = patternList;
    }

    /**
     * @param pattern
     */
    public PatternsetReader(final List<String> pattern) {
	super();

	this.pattern = pattern;
    }

    /**
     * @return Returns the pattern.
     */
    public List<String> getPattern() {
	return pattern;
    }
}
