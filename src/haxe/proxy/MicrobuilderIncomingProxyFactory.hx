package proxy;

using jsonStream.Plugins;
using proxy.MicrobuilderDeserializer;
using proxy.MicrobuilderSerializer;


@:build(jsonStream.rpc.IncomingProxyFactory.generateIncomingProxyFactory([
    "rpc.IUserRpc"
]))
class MicrobuilderIncomingProxyFactory {}