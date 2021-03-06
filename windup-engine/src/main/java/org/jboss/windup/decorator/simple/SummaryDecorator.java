/*
 * Copyright (c) 2013 Red Hat, Inc. and/or its affiliates.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Brad Davis - bradsdavis@gmail.com - Initial API and implementation
*/
package org.jboss.windup.decorator.simple;

import org.jboss.windup.decorator.MetaDecorator;
import org.jboss.windup.resource.decoration.Summary;
import org.jboss.windup.resource.decoration.effort.Effort;
import org.jboss.windup.resource.decoration.effort.UnknownEffort;
import org.jboss.windup.resource.type.FileMeta;

public class SummaryDecorator implements MetaDecorator<FileMeta> {
	protected String description;
	protected Effort effort = new UnknownEffort();

	public void setEffort(Effort effort) {
		this.effort = effort;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void processMeta(FileMeta file) {
		Summary gr = new Summary();
		gr.setDescription(description);
		gr.setEffort(effort);

		file.getDecorations().add(gr);
	}
}
