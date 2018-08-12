package org.tanuneko

import com.typesafe.config.ConfigFactory

trait Config {

  def appConfig = {
    ConfigFactory.load("main")
  }

}
