package githubApiSample

import com.thoughtworks.microbuilder.play.{MainController, PlayOutgoingJsonService, RpcEntry}
import play.api.ApplicationLoader.Context
import play.api.libs.ws.ning.NingWSComponents
import play.api.routing.Router
import play.api.{Application, ApplicationLoader, BuiltInComponentsFromContext}
import proxy.{MicrobuilderIncomingProxyFactory, MicrobuilderOutgoingProxyFactory, MicrobuilderRouteConfigurationFactory}
import router.Routes
import rpc.UserRpc

class SampleLoader extends ApplicationLoader {
  override def load(context: Context): Application = {

    val components = new BuiltInComponentsFromContext(context) with NingWSComponents {
      lazy val routeConfiguration = MicrobuilderRouteConfigurationFactory.routeConfiguration_rpc_IUserRpc()
      lazy val outgoingJsonService = new PlayOutgoingJsonService("https://api.github.com", routeConfiguration, wsApi)(actorSystem.dispatcher)
      lazy val userRpc = MicrobuilderOutgoingProxyFactory.outgoingProxy_rpc_IUserRpc(outgoingJsonService)
      lazy val sampleController = new SampleController(userRpc)(actorSystem.dispatcher)

      val rpcEntry = new RpcEntry(routeConfiguration,
        MicrobuilderIncomingProxyFactory.incomingProxy_rpc_IUserRpc(new UserRpc()))


      lazy val mainController = new MainController(Seq(rpcEntry))
      override lazy val router: Router = new Routes(httpErrorHandler, sampleController, mainController)
    }

    components.application
  }
}
