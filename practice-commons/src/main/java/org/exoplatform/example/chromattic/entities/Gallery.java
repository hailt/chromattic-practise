package org.exoplatform.example.chromattic.entities;

import java.util.Collection;
import java.util.Map;

import org.chromattic.api.annotations.Create;
import org.chromattic.api.annotations.Name;
import org.chromattic.api.annotations.OneToMany;
import org.chromattic.api.annotations.Path;
import org.chromattic.api.annotations.PrimaryType;

@PrimaryType(name = "lab:gallery")
public abstract class Gallery {
	
	/**
	 * Returns the gallery name.
	 * 
	 * @return the gallery name
	 */
	@Name
	public abstract String getName();
	
	@Path 
	public abstract String getPath();
	/**
	 * Returns the photos inside this gallery
	 * 
	 * @return the file children
	 */
	@OneToMany
	public abstract Map<String, Photo> getPhotoMap();
	

	/**
	 * Factory method for photo object.
	 * 
	 * @return a blank content
	 */
	@Create
	public abstract Photo createPhoto();

	
	/**
	 * Returns the collection of photo.
	 * 
	 * @return the photo children collection
	 */
	public Collection<Photo> getPhotos() {
		return getPhotoMap().values();
	}

	/**
	 * Removes a specified photo.
	 * 
	 * @param name
	 *            the photo name
	 */
	public void removePhoto(String name) {
		getPhotoMap().remove(name);
	}
}
