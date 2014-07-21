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
    val m = s"[${msg.fileName}:${msg.line}] ${msg.message}"

    def callUnderlying(
      withCause: (String, Throwable) => Unit,
      withoutCause: String => Unit
    ) = c match {
      case Some(e) => withCause(m, e)
      case None => withoutCause(m)
    }

    msg.level match {
      case Level.Debug => callUnderlying(underlying.debug, underlying.debug)
      case Level.Info => callUnderlying(underlying.info, underlying.info)
      case Level.Warn => callUnderlying(underlying.warn, underlying.warn)
      case Level.Error => callUnderlying(underlying.error, underlying.error)
    }
  }
}
