package eu.over9000.cathode.endpoints.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.*;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.PutFollowsOptions;
import eu.over9000.cathode.endpoints.Users;

public class UsersImpl extends AbstractEndpoint implements Users {
	public UsersImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<User> getUser() {
		return dispatcher.performGet(User.class, "user");
	}

	@Override
	public Result<User> getUser(final String userName) {
		return dispatcher.performGet(User.class, Users.PATH + "/" + userName);
	}

	@Override
	public Result<BlockList> getBlocks(final String userName) {
		return dispatcher.performGet(BlockList.class, Users.PATH + "/" + userName + "/blocks");
	}

	@Override
	public Result<Void> deleteBlock(final String userName, final String targetName) {
		return dispatcher.performDelete(Void.class, Users.PATH + "/" + userName + "/blocks/" + targetName);
	}

	@Override
	public Result<Block> putBlock(final String userName, final String targetName) {
		return dispatcher.performPut(Block.class, Users.PATH + "/" + userName + "/blocks/" + targetName);
	}

	@Override
	public Result<FollowList> getFollows(final String userName, final OffsetPagination pagination) {
		return dispatcher.performGet(FollowList.class, Users.PATH + "/" + userName + "/follows", pagination);
	}

	@Override
	public Result<Follow> getFollows(final String userName, final String targetName) {
		return dispatcher.performGet(Follow.class, Users.PATH + "/" + userName + "/follows/" + targetName);
	}

	@Override
	public Result<Follow> putFollows(final String userName, final String targetName, final PutFollowsOptions options) {
		return dispatcher.performPut(Follow.class, Users.PATH + "/" + userName + "/follows/" + targetName, options);
	}

	@Override
	public Result<Void> deleteFollows(final String userName, final String targetName) {
		return dispatcher.performDelete(Void.class, Users.PATH + "/" + userName + "/follows/" + targetName);
	}

	@Override
	public Result<Subscription> getSubscription(final String userName, final String channelName) {
		return dispatcher.performGet(Subscription.class, Users.PATH + "/" + userName + "/subscriptions/" + channelName);
	}
}
