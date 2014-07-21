package io.buildo.ingredients.logging.transport

import io.buildo.ingredients.logging._

import org.slf4j.{ LoggerFactory, Logger => Underlying }

class SLF4J extends Transport {
  private val loggers = scala.collection.mutable.HashMap[String, Underlying]()

  def write(name: String, msg: LogMessage): Unit = {
    val underlying = loggers.get(name) getOrElse {
      var l = LoggerFactory.getLogger(name)
      loggers += (name -> l)
      l
    }
    val c = msg.cause
    val m = msg.message.toString
    msg.level match {
      case Level.Debug => {
        if (c.isDefined)
          underlying.debug(m, c.get)
        else
          underlying.debug(m)
      }
      case Level.Info => {
        if (c.isDefined)
          underlying.info(m, c.get)
        else
          underlying.info(m)
      }
      case Level.Warn => {
        if (c.isDefined)
          underlying.warn(m, c.get)
        else
          underlying.warn(m)
      }
      case Level.Error => {
        if (c.isDefined)
          underlying.error(m, c.get)
        else
          underlying.error(m)
      }
    }
  }
}
