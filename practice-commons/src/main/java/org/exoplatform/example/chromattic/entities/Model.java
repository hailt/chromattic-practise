/*
 * Copyright (C) 2010 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.exoplatform.example.chromattic.entities;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;

import org.chromattic.api.ChromatticSession;

/**
 * A facade for accessing the virtual file system.
 * 
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
public class Model {

	/** . */
	private ChromatticSession session;

	public Model(ChromatticSession session) {
		this.session = session;
	}

	public Gallery getGallery(String folderPath) throws Exception {

		Node folder = session.getJCRSession().getRootNode().getNode(folderPath);
		if (folder == null) {
			throw new PathNotFoundException("Folder path does not exist.");
		}

		Node galleryNode = null;
		if (!folder.hasNode("gallery")) {
			galleryNode = folder.addNode("gallery", "lab:gallery");
			session.save();
		} else {
			galleryNode = folder.getNode("gallery");
		}

		return session.findByNode(Gallery.class, galleryNode);
	}

	/**
	 * Saves the changes made to the model.
	 */
	public void save() {
		session.save();
	}

	/**
	 * Close the connection to the model.
	 */
	public void close() {
		session.close();
	}
}
