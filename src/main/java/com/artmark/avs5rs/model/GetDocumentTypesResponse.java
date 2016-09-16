package com.artmark.avs5rs.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 10:59
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDocumentTypesResponse")
public class GetDocumentTypesResponse {
	@XmlElement(name = "DocumentType")
	private List<DocumentType> documentTypes;

	public List<DocumentType> getDocumentTypes() {
		return documentTypes;
	}

	public void setDocumentTypes(List<DocumentType> documentTypes) {
		this.documentTypes = documentTypes;
	}
}
