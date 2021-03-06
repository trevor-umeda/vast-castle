class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(view:"/main")
				"/tag/search"(controller: "tag", action:"search")
        "500"(view:'/error')
        "/images"(controller: "image") {
            action = [ GET: "getImages", POST:"createImage"]
        }

        "/image"(controller:"image") {
            action = [ GET: "getImage"]
        }

        "/health"(controller:"image") {
            action = [ GET: "health"]
        }

        "/tags"(controller: "tag") {
            action = [ GET:"getTags", POST:"tagImage" ]
        }

        "/tagImage"(controller: "tag") {
            action = [ POST:"tagImage" ]
        }

        "/sanitize"(controller: "tag") {
            action = [ POST: "sanitize"]
        }
	}
}
