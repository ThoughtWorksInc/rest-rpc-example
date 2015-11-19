package rpc;

import jsonStream.rpc.Future;
import model.User;

@:nativeGen
interface IUserRpc {
    @:route("GET", "/users/{username}")
    function getSingleUser(username:String):Future<User>;
}