package rpc

import com.thoughtworks.microbuilder.play.Implicits.scalaFutureToJsonStreamFuture
import jsonStream.rpc.IFuture1
import model.User

import scala.concurrent.Future

/**
 * Created by zwshao on 11/19/15.
 */
class UserRpc extends IUserRpc {
    override def getSingleUser(username: String): IFuture1[User] = {
      val user = new User()
      user.name = "xiaoshao"
      user.email ="zwshao@thoughtworks.com"
      user.followers = 100
      user.avatar_url = "http://s1.rui.au.reastatic.net/rui-static/img/rea-logo-v3.png"
      Future.successful(user)
    }
}
