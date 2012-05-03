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

import java.util.Collection;
import java.util.Map;

import org.chromattic.api.annotations.Create;
import org.chromattic.api.annotations.Id;
import org.chromattic.api.annotations.ManyToOne;
import org.chromattic.api.annotations.Name;
import org.chromattic.api.annotations.OneToMany;
import org.chromattic.api.annotations.Path;
import org.chromattic.api.annotations.PrimaryType;

/**
 * Models an <code>nt:folder</code> node.
 * 
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
@PrimaryType(name = "nt:folder")
public abstract class Folder {

	/**
	 * Returns the folder id.
	 * 
	 * @return the folder id
	 */
	@Id
	public abstract String getId();

	/**
	 * Returns the folder path.
	 * 
	 * @return the folder path
	 */
	@Path
	public abstract String getPath();

	/**
	 * Returns the folder name.
	 * 
	 * @return the folder name
	 */
	@Name
	public abstract String getName();

	/**
	 * Returns the directory containing this folder.
	 * 
	 * @return the parent directory
	 */
	@ManyToOne
	public abstract Folder getParent();

	/**
	 * Factory method for gallery object.
	 * 
	 * @return a blank content
	 */
	@Create
	protected abstract Gallery createGallery();

	/**
	 * Returns the gallery children of this directory
	 * 
	 * @return the gallery children
	 */
	@OneToMany
	protected abstract Map<String, Gallery> getGalleryMap();

	/**
	 * Returns the collection of gallery children.
	 * 
	 * @return the gallery children collection
	 */
	public Collection<Gallery> getGalleries() {
		return getGalleryMap().values();
	}

	/**
	 * Returns a specified gallery
	 * 
	 * @param name
	 *            the gallery name
	 * @return the document
	 */
	public Gallery getGallery(String name) {
		return getGalleryMap().get(name);
	}

	/**
	 * Creates a gallery.
	 * 
	 * @param name
	 *            the gallery name
	 * 
	 * @return the created gallery
	 */
	public Gallery addGallery(String name) {
		Gallery gallery = createGallery();
		getGalleryMap().put(name, gallery);
		return gallery;
	}
}
