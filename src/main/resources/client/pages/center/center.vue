<template>
	<view class="content">
		<view :style='{"width":"100%","padding":"0px 0 120rpx","position":"relative","background":"#fff","height":"auto"}'>
			<view v-if="user&&user.id" :style='{"border":"0px solid #3da742","padding":"24rpx 24rpx 24rpx 24rpx","margin":"0px 0px 20rpx 0px","borderRadius":"0px","background":"none","display":"flex","width":"calc(100% - 0px)","justifyContent":"space-between","height":"auto"}' class="header" v-bind:class="{'status':isH5Plus}" @tap="onPageTap2('../user-info/user-info',1)">
				<view :style='{"padding":"60rpx 40rpx 60rpx 60rpx","alignItems":"flex-start","flexWrap":"wrap","flexDirection":"column","background":"url(http://clfile.zggen.cn/20231130/c1afd58fef044a0ea8e3bcc3c7c6f70d.png) no-repeat center top / 100% 100%,#fdfce8","display":"flex","width":"calc(96% - 112rpx)","height":"100%"}' v-if="tableName=='yonghu'" class="userinfo">
					<image :style='{"width":"108rpx","padding":"0 0 0 0","margin":"0 20rpx 0 0","borderRadius":"100%","height":"108rpx"}' :src="user.touxiang?baseUrl+user.touxiang:'/static/gen/upload.png'"></image>
					<view :style='{"margin":"20rpx 0 0 0","flex":"1","flexDirection":"column","display":"flex","width":"100%","justifyContent":"center","height":"100%"}' class="info">
						<view :style='{"width":"100%","lineHeight":"36rpx","fontSize":"28rpx","color":"#333","fontWeight":"600"}'>{{user.yonghuzhanghao}}<text v-if="user.vip&& user.vip=='是'">(VIP)</text></view>
						<view :style='{"width":"100%","lineHeight":"36rpx","fontSize":"28rpx","color":"#333"}' v-if="user.money">余额：{{user.money}}</view>
						<view :style='{"width":"100%","lineHeight":"36rpx","fontSize":"28rpx","color":"#333"}' v-if="user.jf||user.jf==0">积分：{{user.jf}}</view>
					</view>
				</view>
				<view :style='{"padding":"60rpx 40rpx 60rpx 60rpx","alignItems":"flex-start","flexWrap":"wrap","flexDirection":"column","background":"url(http://clfile.zggen.cn/20231130/c1afd58fef044a0ea8e3bcc3c7c6f70d.png) no-repeat center top / 100% 100%,#fdfce8","display":"flex","width":"calc(96% - 112rpx)","height":"100%"}' v-if="tableName=='shangjia'" class="userinfo">
					<view :style='{"margin":"20rpx 0 0 0","flex":"1","flexDirection":"column","display":"flex","width":"100%","justifyContent":"center","height":"100%"}' class="info">
						<view :style='{"width":"100%","lineHeight":"36rpx","fontSize":"28rpx","color":"#333","fontWeight":"600"}'>{{user.shangjiazhanghao}}<text v-if="user.vip&& user.vip=='是'">(VIP)</text></view>
						<view :style='{"width":"100%","lineHeight":"36rpx","fontSize":"28rpx","color":"#333"}' v-if="user.money">余额：{{user.money}}</view>
						<view :style='{"width":"100%","lineHeight":"36rpx","fontSize":"28rpx","color":"#333"}' v-if="user.jf||user.jf==0">积分：{{user.jf}}</view>
					</view>
				</view>
				<view :style='{"border":"0px solid #eeeeee","margin":"24rpx 24rpx 0 0","alignItems":"center","display":"flex","width":"72rpx","justifyContent":"center","height":"100%"}' class="setting">
					<view :style='{"border":"0px solid #eeeeee","width":"84rpx","lineHeight":"84rpx","fontSize":"84rpx","color":"#333","borderRadius":"0px"}' class="iconfont icon-shezhi1"></view>
				</view>
			</view>
			<view v-else :style='{"border":"0px solid #3da742","padding":"24rpx 24rpx 24rpx 24rpx","margin":"0px 0px 20rpx 0px","borderRadius":"0px","background":"none","display":"flex","width":"calc(100% - 0px)","justifyContent":"space-between","height":"auto"}' class="header" v-bind:class="{'status':isH5Plus}" @tap="onPageTap2('../user-info/user-info',1)">
				<view :style='{"alignItems":"center","textAlign":"center","display":"flex","width":"100%","fontSize":"40rpx","justifyContent":"center","height":"100%"}'>登录/注册</view>
			</view>
			<view class="orderBox" v-if="user">
				<view class="orderTitle">商品订单</view>
				<view class="orderList">
					<view class="orderView" v-for="(item,index) in orderList" :key="index" @click="orderClick(item.name)">
						<view class="orderIcons">
							<i class="iconfont" :class="item.icon"></i>
						</view>
						<view class="orderName">{{item.name}}</view>
					</view>
				</view>
			</view>
			<view :style='{"padding":"0px 20rpx 40rpx 20rpx","margin":"40rpx 20rpx 120rpx 20rpx","borderRadius":"8rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 40rpx)","justifyContent":"space-between","height":"auto"}' class="list">
				<block v-for="(item,index) in menuList" v-bind:key="item.roleName" v-if="item.child.length&&item.child[0].tableName!='orders'">
					<block v-if="item.child.length>1&&item.child[0].tableName!='orders'">
						<view @tap="secondClick(index)" :style='{"border":"2rpx solid #dddddd","padding":"0 40rpx 0 0","margin":"0 0 20rpx 0","alignItems":"center","textAlign":"center","display":"flex","transition":"all 0s","borderRadius":"8rpx","flexWrap":"wrap","background":"#fff00010","width":"48%","position":"relative","height":"80rpx"}'
							class="li" hover-class="hover">
							<view v-if="false" :style='{"width":"48rpx","fontSize":"48rpx","color":"#2f72e3","display":"inline-block"}' :class="item.fontClass"></view>
							<view :style='{"padding":"0 20rpx 0 20rpx","margin":"0 0 0 0","color":"#333333","display":"inline-block","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}' class="text">{{item.menu}}</view>
							<view v-if="true" :style='{"color":"#999999","top":"32rpx","width":"28rpx","lineHeight":"28rpx","fontSize":"28rpx","position":"absolute","right":"20rpx"}' class="iconfont icon-gengduo2"></view>
						</view>
						<uni-transition :style='{"width":"100%","padding":"0px","margin":"0 0 24rpx 0"}' :mode-class="['fade']" :duration="500"
							:show="secondIndex==index?true:false">
							<block v-bind:key="sort" v-for=" (child,sort) in item.child">
								<view :style='{"padding":"0 20rpx 0 20rpx","borderColor":"#eeeeee","margin":"0 0 0 0","alignItems":"center","borderWidth":"0 0 0px 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'
									v-if="child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan'  && child.tableName!='examquestion' "
									@tap="onPageTap(child.tableName,child.menuJump)"
									class="li" hover-class="hover">
									<view :style='{"width":"100%","padding":"0 20rpx 0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#999999","flex":"1"}' class="text">{{child.menu}}</view>
									<view v-if="false" :style='{"width":"28rpx","lineHeight":"28rpx","fontSize":"28rpx","color":"#999999"}' class="iconfont icon-gengduo2"></view>
								</view>
							</block>
						</uni-transition>
					</block>
					<block v-else-if="item.child.length&&item.child[0].tableName=='orders'">
						<view :style='{"border":"2rpx solid #dddddd","padding":"0 40rpx 0 0","margin":"0 0 20rpx 0","alignItems":"center","textAlign":"center","display":"flex","transition":"all 0s","borderRadius":"8rpx","flexWrap":"wrap","background":"#fff00010","width":"48%","position":"relative","height":"80rpx"}' @tap="onPageTap(item.child[0].tableName,item.child[0].menuJump)"
							class="li" hover-class="hover">
							<view v-if="false" :style='{"width":"48rpx","fontSize":"48rpx","color":"#2f72e3","display":"inline-block"}' :class="item.fontClass"></view>
							<view :style='{"padding":"0 20rpx 0 20rpx","margin":"0 0 0 0","color":"#333333","display":"inline-block","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}' class="text">{{item.menu}}</view>
							<view v-if="true" :style='{"color":"#999999","top":"32rpx","width":"28rpx","lineHeight":"28rpx","fontSize":"28rpx","position":"absolute","right":"20rpx"}' class="iconfont icon-gengduo2"></view>
						</view>
					</block>
					<block v-else>
						<view :style='{"border":"2rpx solid #dddddd","padding":"0 40rpx 0 0","margin":"0 0 20rpx 0","alignItems":"center","textAlign":"center","display":"flex","transition":"all 0s","borderRadius":"8rpx","flexWrap":"wrap","background":"#fff00010","width":"48%","position":"relative","height":"80rpx"}' @tap="onPageTap(item.child[0].tableName,item.child[0].menuJump)"
							class="li" hover-class="hover">
							<view v-if="false" :style='{"width":"48rpx","fontSize":"48rpx","color":"#2f72e3","display":"inline-block"}' :class="item.fontClass"></view>
							<view :style='{"padding":"0 20rpx 0 20rpx","margin":"0 0 0 0","color":"#333333","display":"inline-block","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}' class="text">{{item.child[0].menu}}</view>
							<view v-if="true" :style='{"color":"#999999","top":"32rpx","width":"28rpx","lineHeight":"28rpx","fontSize":"28rpx","position":"absolute","right":"20rpx"}' class="iconfont icon-gengduo2"></view>
						</view>
					</block>
				</block>
				<view v-if="user&&user.id" @tap="onPageTap2('../shop-recharge/pay-confirm')" :style='{"border":"2rpx solid #dddddd","padding":"0 40rpx 0 0","margin":"0 0 20rpx 0","alignItems":"center","textAlign":"center","display":"flex","transition":"all 0s","borderRadius":"8rpx","flexWrap":"wrap","background":"#fff00010","width":"48%","position":"relative","height":"80rpx"}' class="li" hover-class="hover">
					<view v-if="false" :style='{"width":"48rpx","fontSize":"48rpx","color":"#2f72e3","display":"inline-block"}' class="iconfont icon-chongzhi4"></view>
					<view class="text" :style='{"padding":"0 20rpx 0 20rpx","margin":"0 0 0 0","color":"#333333","display":"inline-block","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>用户充值</view>
					<view v-if="true" :style='{"color":"#999999","top":"32rpx","width":"28rpx","lineHeight":"28rpx","fontSize":"28rpx","position":"absolute","right":"20rpx"}' class="iconfont icon-gengduo2"></view>
				</view>

				<view v-if="user&&user.id" @tap="passwordShow()" :style='{"border":"2rpx solid #dddddd","padding":"0 40rpx 0 0","margin":"0 0 20rpx 0","alignItems":"center","textAlign":"center","display":"flex","transition":"all 0s","borderRadius":"8rpx","flexWrap":"wrap","background":"#fff00010","width":"48%","position":"relative","height":"80rpx"}' class="li" hover-class="hover">
					<view v-if="false" :style='{"width":"48rpx","fontSize":"48rpx","color":"#2f72e3","display":"inline-block"}' class="iconfont $template2.front.me.list.img.updatepasswod"></view>
					<view class="text" :style='{"padding":"0 20rpx 0 20rpx","margin":"0 0 0 0","color":"#333333","display":"inline-block","width":"auto","lineHeight":"48rpx","fontSize":"28rpx"}'>修改密码</view>
					<view v-if="true" :style='{"color":"#999999","top":"32rpx","width":"28rpx","lineHeight":"28rpx","fontSize":"28rpx","position":"absolute","right":"20rpx"}' class="iconfont icon-gengduo2"></view>
				</view>
			</view>
		</view>
		<uni-popup class="popup-content" ref="passwordPopup" type="bottom">
			<view class="passwordForm">
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.mima" placeholder="原密码" />
				</view>
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.newmima" placeholder="新密码" />
				</view>
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.newmima1" placeholder="确认密码" />
				</view>
				<view class="passwordBtnView">
					<button class="passwordBtn" @click="updatePassword">更新</button>
				</view>
			</view>
		</uni-popup>
	</view>
</template>
<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				isH5Plus: true,
				user: {},
				tableName:'',
				role: '',
				menuList: [],
				secondIndex: -1,
				orderList: [{
						name: '全部',
						icon: 'icon-dingdan1'
					},
					{
						name: '未支付',
						icon: 'icon-dingdan2'
					},
					{
						name: '已支付',
						icon: 'icon-dingdan3'
					},
					{
						name: '已完成',
						icon: 'icon-dingdan4'
					},
					{
						name: '已取消',
						icon: 'icon-dingdan5'
					},
				],
				passwordForm: {
					mima: '',
					newmima: '',
					newmima1: '',
				},
			};
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onLoad(){
			this.role = uni.getStorageSync("appRole");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			for (let x in menus) {
				if (menus[x].tableName == this.tableName) {
					this.menuList = menus[x].backMenu
					break
				}
			}
		},
		async onShow(){
            uni.removeStorageSync("useridTag");
			this.role = uni.getStorageSync("appRole");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			for (let x in menus) {
				if (menus[x].tableName == this.tableName) {
					this.menuList = menus[x].backMenu
					break
				}
			}
		},
		methods: {
			async getSession(){
				let table = uni.getStorageSync("nowTable");
				let res = await this.$api.session(table);
				this.user = res.data;
				this.$forceUpdate()
			},
			orderClick(name){
				uni.navigateTo({
					url: '../shop-order/shop-order?status=' + name,
					fail: function() {
						uni.switchTab({
							url: '../shop-order/shop-order?status=' + name
						});
					}
				});
			},
			secondClick(index) {
				if (this.secondIndex == index) {
					this.secondIndex = -1
					return false
				}
				this.secondIndex = index
			},
			onPageTap(tableName,menuJump) {
                uni.setStorageSync("useridTag",1);
				if(tableName=='cart'){
					this.onPageTap2('../shop-cart/shop-cart')
					return false
				}
				if(tableName=='exampaper'){
					this.onPageTap2('../exampaperlist/list')
					return false
				}
				if(tableName=='examrecord'&&menuJump=='22'){
					this.onPageTap2('../examfailrecord/list',2)
					return false
				}
				if(tableName=='storeup'){
					this.onPageTap2('../storeup/list?userid=' + this.user.id + '&menuJump=' + menuJump ,1)
					return false
				}
				this.onPageTap2(`../${tableName}/list`,2)
			},
			onPageTap2 (url,type=1){
				if(!this.user){
					uni.navigateTo({
						url:'/pages/login/login'
					})
					return false
				}
				let that = this
				uni.navigateTo({
					url: url + (type==2?`?userid=${that.user.id}`:''),
					fail: function() {
						uni.switchTab({
							url: url + (type==2?`?userid=${that.user.id}`:'')
						});
					}
				});
			},
			passwordShow() {
				this.passwordForm = {
					mima: '',
					newmima: '',
					newmima1: '',
				}
				this.$forceUpdate()
				this.$refs.passwordPopup.open()
			},
			async updatePassword() {
				if (this.passwordForm.mima == ''){
					this.$utils.msg('原密码不能为空')
					return false
				}
				if (this.passwordForm.newmima == ''){
					this.$utils.msg('新密码不能为空')
					return false
				}
				if (this.passwordForm.newmima1 == ''){
					this.$utils.msg('确认密码不能为空')
					return false
				}
				let password = ''
				if (this.tableName=='yonghu') {
					password = this.user.yonghumima;
				}
				let newpassword = this.passwordForm.mima
				if(password != newpassword){
					this.$utils.msg('原密码不正确')
					return false
				}
				if (this.passwordForm.newmima != this.passwordForm.newmima1){
					this.$utils.msg('两次密码不一致')
					return false
				}
				if (this.tableName == 'yonghu') {
				}
				if (this.tableName=='yonghu') {
					this.user.yonghumima = this.passwordForm.newmima
				}
				await this.$api.update(this.tableName,this.user)
				this.$utils.msg('修改密码成功,下次登录系统生效')
				this.$refs.passwordPopup.close()
				this.getSession()
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		height: calc(100vh - 94px);
		box-sizing: border-box;
	}
	.orderBox {
		border-radius: 8rpx;
		padding: 12rpx 0;
		box-shadow: 0 0px 0px rgba(0,0,0,.3);
		margin: 0px 20rpx 0 20rpx;
		background: none;
		width: calc(100% - 40rpx);
		.orderTitle{
			padding: 30rpx;
			margin: 0 20rpx 20rpx 20rpx;
			color: #333;
			background: url(http://clfile.zggen.cn/20231130/99a276c461c94b9a9ab19652b1976f71.png) no-repeat center top / 100% 100%;
			font-weight: 500;
			width: calc(100% - 40rpx);
			font-size: 28rpx;
			border-color: #3da742;
			border-width: 0 0 0px 0;
			border-style: solid;
			text-align: center;
		}
		
		.orderList{
			padding: 0;
			margin: 0;
			display: flex;
			width: 100%;
			justify-content: space-between;
			align-items: center;
			box-sizing: border-box;
			.orderView {
				margin: 10rpx 2% 20rpx 0;
				flex-direction: column;
				display: flex;
				width: 23%;
				align-items: center;
				
				.orderIcons {
					border-radius: 40rpx;
					background: none;
					display: flex;
					width: 80rpx;
					justify-content: center;
					align-items: center;
					height: 80rpx;
			
					.iconfont {
						border: 2rpx solid #666666;
						padding: 8rpx;
						color: #ff746d;
						background: #fff000;
						font-size: 64rpx;
					}
				}
			
				.orderName {
					padding: 12rpx 0 0;
					width: 100%;
					font-size: 24rpx;
					text-align: center;
				}
			}
		}
	}
	.passwordForm {
		width: 100%;
		padding: 10px 20px 60px;
		background: #fff;
	
		.passwordInput {
			background: #eee;
			margin: 0 0 10px;
			padding: 0 10px;
	
			input {
				height: 36px;
				line-height: 36px;
				font-size: 14px;
			}
		}
	
		.passwordBtnView {
			width: 100%;
			display: flex;
			align-items: center;
			justify-content: center;
			padding: 10px 0;
	
			.passwordBtn {
				padding: 0 20px;
				width: auto;
				height: 20px;
				line-height: 20px;
				font-size: 14px;
				color: #fff;
				background: #007aff;
				border: none;
				border-radius: 5px;
	
			}
		}
	}
</style>
