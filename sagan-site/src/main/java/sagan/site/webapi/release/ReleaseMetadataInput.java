package sagan.site.webapi.release;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public class ReleaseMetadataInput {

	@NotBlank
	@Pattern(regexp = "[\\d\\w.]*\\.x")
	private final String version;

	private final boolean isCurrent;

	@URL
	private final String referenceDocUrl;

	@URL
	private final String apiDocUrl;

	@JsonCreator
	public ReleaseMetadataInput(@JsonProperty("version") String version,
			@JsonProperty("isCurrent") boolean isCurrent,
			@JsonProperty("referenceDocUrl") String referenceDocUrl, @JsonProperty("apiDocUrl") String apiDocUrl) {
		this.version = version;
		this.isCurrent = isCurrent;
		this.referenceDocUrl = referenceDocUrl;
		this.apiDocUrl = apiDocUrl;
	}

	public String getVersion() {
		return this.version;
	}

	public boolean isCurrent() {
		return this.isCurrent;
	}

	public String getReferenceDocUrl() {
		return this.referenceDocUrl;
	}

	public String getApiDocUrl() {
		return this.apiDocUrl;
	}

}
