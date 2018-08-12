package org.tanuneko

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import org.tanuneko.marshaller.HealthMarshalling
import org.tanuneko.model.{Health, Healthy, Unhealthy}
import org.tanuneko.service.HealthCheckService
import spray.json._

class RestRouter(
  healthCheckService: HealthCheckService
) extends HealthMarshalling
with JsonResponseHelper {

  import akka.http.scaladsl.model.StatusCodes._

  // when new handler is added, enhance like below
  // def routes: Route = healthCheckHandler ~ newHandler ~ newHandler2
  def routes: Route = healthCheckHandler

  def healthCheckHandler = {
    pathPrefix("health") {
      get {
        onSuccess(healthCheckService.check) { result =>
          result.status match {
            case Healthy => asJsonResponse(OK, result.toJson.prettyPrint)
            case Unhealthy(_) => asJsonResponse(InternalServerError, result.toJson.prettyPrint)
          }
        }
      }
    }
  }
}
