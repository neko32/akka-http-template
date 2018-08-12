package org.tanuneko.marshaller

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import org.tanuneko.model.{Health, HealthStatus, Healthy, Unhealthy}
import spray.json._
import spray.json.DefaultJsonProtocol._

trait HealthMarshalling extends SprayJsonSupport with DefaultJsonProtocol {

   implicit val healthStatusFormat = new RootJsonFormat[HealthStatus] {
     def write(status: HealthStatus): JsValue = {
       status match {
         case Healthy =>
           JsObject(
            "value" -> JsString("Healthy"),
            "reasons" -> List("Healthy").toJson
           )
         case Unhealthy(reasons) =>
           JsObject(
            "value" -> JsString("Unhealthy"),
            "reasons" -> reasons.getOrElse(List.empty).toJson
           )
       }
     }
     def read(value: JsValue): HealthStatus = {
        val fields = value.asJsObject.fields  
        fields.get("reasons") match {
          case None => Healthy
          case Some(reasons) if reasons.convertTo[List[String]].head == "Healthy" => Healthy
          case Some(reasons) =>  Unhealthy(reasons.convertTo[Option[List[String]]])
        }
     }
   }

   implicit val heathFormat = jsonFormat2(Health)

}

object HealthMarshalling extends HealthMarshalling
