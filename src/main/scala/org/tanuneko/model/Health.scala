package org.tanuneko.model

// Health ADT
case class Health(name: String, status: HealthStatus)

sealed trait HealthStatus
case object Healthy extends HealthStatus
case class Unhealthy(reasons: Option[List[String]]) extends HealthStatus

