package sagan.site.webapi;

import sagan.site.webapi.project.ProjectMetadata;
import sagan.site.webapi.repository.RepositoryMetadata;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Lists all resources at the root of the Web API
 */
@RestController
class IndexController {

	private final EntityLinks entityLinks;

	IndexController(EntityLinks entityLinks) {
		this.entityLinks = entityLinks;
	}

	@GetMapping(path = "/api", produces = MediaTypes.HAL_JSON_VALUE)
	public ResourceSupport index() {
		ResourceSupport resource = new ResourceSupport();
		resource.add(this.entityLinks.linkToCollectionResource(ProjectMetadata.class).withRel("projects"));
		resource.add(this.entityLinks.linkToCollectionResource(RepositoryMetadata.class).withRel("repositories"));
		return resource;
	}
}
