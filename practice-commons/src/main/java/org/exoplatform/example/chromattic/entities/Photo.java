package org.exoplatform.example.chromattic.entities;

import java.io.InputStream;
import java.util.Date;

import org.chromattic.api.annotations.Create;
import org.chromattic.api.annotations.Id;
import org.chromattic.api.annotations.ManyToOne;
import org.chromattic.api.annotations.MappedBy;
import org.chromattic.api.annotations.Name;
import org.chromattic.api.annotations.OneToOne;
import org.chromattic.api.annotations.Owner;
import org.chromattic.api.annotations.Path;
import org.chromattic.api.annotations.PrimaryType;
import org.chromattic.api.annotations.Property;

@PrimaryType(name = "lab:photo")
public abstract class Photo{
	/**
	 * Returns the photo id.
	 * 
	 * @return the photo id
	 */
	@Id
	public abstract String getId();

	/**
	 * Returns the photo path.
	 * 
	 * @return the photo path
	 */
	@Path
	public abstract String getPath();

	/**
	 * Returns the photo name.
	 * 
	 * @return the photo name
	 */
	@Name
	public abstract String getName();
	
	public abstract void setName(String name);

	/**
	 * Returns the gallery containing this photo.
	 * 
	 * @return the parent gallery
	 */

	@ManyToOne
	public abstract Gallery getParent();

	/**
	 * Returns the creation date of this photo.
	 * 
	 * @return the creation date
	 */
	@Property(name = "jcr:created")
	public abstract Date getCreated();

	/**
	 * Returns the photo's content or null if no content is associated with
	 * this photo.
	 * 
	 * @return the photo content
	 */
	@OneToOne
	@Owner
	@MappedBy("jcr:content")
	public abstract Content getContent();

	/**
	 * Set the photo content.
	 * 
	 * @param content
	 *            the photo content
	 */
	public abstract void setContent(Content content);

	/**
	 * Factory method for content object.
	 * 
	 * @return a blank content
	 */
	@Create
	protected abstract Content createContent();

	/**
	 * Updates the current photo with the specified mime type and data.
	 * 
	 * @param mimeType
	 *            the mime type
	 * @param data
	 *            the data
	 */
	public void update(String mimeType, InputStream data) {
		Content content = getContent();

		//
		if (content == null) {
			content = createContent();
			setContent(content);
		}

		//
		content.setData(data);
		content.setMimeType(mimeType);
		content.setLastModified(new Date());
	}
}
