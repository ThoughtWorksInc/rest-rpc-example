package controllers

import com.thoughtworks.restRpc.callee.{RpcEntry, MainController}
import play.api.ApplicationLoader.Context
import play.api.{ApplicationLoader, BuiltInComponentsFromContext}
import router.Routes

class MyApplicationLoader extends ApplicationLoader{
  def load(context: Context) = {
    new MyComponents(context).application
  }
}

class MyComponents(context: Context) extends BuiltInComponentsFromContext(context) {
  lazy val router = new Routes(httpErrorHandler, applicationController, mainController, assets)

  lazy val rpcImplementations = Seq[RpcEntry]()
  lazy val mainController = new MainController(rpcImplementations)
  lazy val applicationController = new controllers.Application()
  lazy val assets = new controllers.Assets(httpErrorHandler)
}