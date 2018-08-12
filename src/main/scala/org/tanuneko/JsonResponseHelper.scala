package org.tanuneko

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpResponse, StatusCode}
import akka.util.ByteString
import spray.json._

trait JsonResponseHelper {

  def asJsonResponse[A <: String](status: StatusCode, content: A) = {
    complete(HttpResponse(status, entity = HttpEntity(ContentTypes.`application/json`, content)))
  }
}
