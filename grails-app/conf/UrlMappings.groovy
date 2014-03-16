class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "/images"(controller: "image") {
            action = [ GET: "getImages", POST:"createImage" ]
        }

        "/tags"(controller: "tag") {
            action = [ POST:"tagImage" ]
        }
	}
}
