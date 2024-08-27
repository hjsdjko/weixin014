<template>
	<view class="content">
		<view class="box" :style='{"minHeight":"100vh","width":"100%","padding":"160rpx 44rpx 244rpx 44rpx","background":"url(http://clfile.zggen.cn/20231130/51b25124d35a4e059579e6c84f9948aa.jpg) no-repeat center top / 100%,#ffffff","height":"100%"}'>
			<view :style='{"padding":"48rpx 48rpx 48rpx 48rpx","boxShadow":"0px 0px 12rpx #dddddd","margin":"0 0 244rpx 0","borderRadius":"4rpx","background":"#ffffff","display":"block","width":"100%","position":"relative","height":"auto"}'>
				<image :style='{"width":"160rpx","margin":"0 0 40rpx 0","borderRadius":"100%","objectFit":"cover","display":"none","height":"160rpx"}' src="http://clfile.zggen.cn/20231027/4b7b24d658fd400e849c8c2314e29d56.jpg" mode="aspectFill"></image>
				<view v-if="loginType==1" :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"40rpx","background":"#00000040","height":"auto"}' class="uni-form-item uni-column">
					<input v-model="username" :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}' type="text" class="uni-input" name="" placeholder="请输入账号" />
				</view>
				<view v-if="loginType==1" :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"40rpx","background":"#00000040","height":"auto"}' class="uni-form-item uni-column">
					<input v-model="password" :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}' type="password" class="uni-input" name="" placeholder="请输入密码" />
				</view>
				<picker v-if="roleNum>1" :style='{"border":"2rpx solid #00000010","padding":"0 20rpx","margin":"0 0 24rpx 0","borderRadius":"0px","background":"#ffffff","width":"100%","height":"auto"}' @change="optionsChange" :value="index" :range="options">
					<view class="uni-picker-type" :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#999999"}'>{{options[index]}}</view>
				</picker>
				<button v-if="loginType==1" class="btn-submit" @tap="onLoginTap" type="primary" :style='{"border":"2rpx solid #dddddd","padding":"0 0 0 0","margin":"0 0 24rpx 0","color":"#333","borderRadius":"0px","background":"#fff000","width":"100%","lineHeight":"80rpx","fontSize":"32rpx","height":"80rpx"}'>登录</button>
				<button v-if="loginType==2" class="btn-submit" @tap="onFaceLoginTap" type="primary" :style='{"border":"2rpx solid #dddddd","padding":"0 0 0 0","margin":"0 0 24rpx 0","color":"#333","borderRadius":"0px","background":"#fff000","width":"100%","lineHeight":"80rpx","fontSize":"32rpx","height":"80rpx"}'>人脸识别登录</button>
				<view class="links" :style='{"width":"100%","margin":"0 0 24rpx 0","flexWrap":"wrap","display":"flex","height":"auto"}'>
					<view class="link-highlight" @tap="onRegisterTap('yonghu')" :style='{"color":"#999999","padding":"0 8rpx 0 8rpx","fontSize":"28rpx"}'>注册用户</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				username: '',
				password: '',
                loginType:1,
				codes: [{
				  num: 1,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 2,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 3,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 4,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}],
				options: [
					'请选择登录用户类型',
				],
                optionsValues: [
					'',
                    'yonghu',
				],
				index: 1,
				roleNum:0,
			}
		},
		onLoad() {
			let options = ['请选择登录用户类型'];
			let menus = menu.list();
			this.menuList = menus;
			for(let i=0;i<this.menuList.length;i++){
				if(this.menuList[i].hasFrontLogin=='是'){
					options.push(this.menuList[i].roleName);
					this.roleNum++;
				}
			}
			if(this.roleNum==1) {
				this.index = 1;
			}	
			this.options = options;
			this.styleChange()
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.loginFrom.content.input.backgroundColor
					// })
				})
			},
			onRegisterTap(tableName) {
                uni.setStorageSync("loginTable", tableName);
				this.$utils.jump('../register/register')
			},
			async onLoginTap() {
                if (!this.username) {
					this.$utils.msg('请输入用户名')
					return
				}
                if (!this.password) {
					this.$utils.msg('请输入用户密码')
					return
				}
                if (!this.optionsValues[this.index]) {
					this.$utils.msg('请选择登录用户类型')
					return
				}
				let res = await this.$api.login(`${this.optionsValues[this.index]}`, {
					username: this.username,
					password: this.password
				});
                uni.removeStorageSync("useridTag");
				uni.setStorageSync("token", res.token);
				uni.setStorageSync("nickname",this.username);
				uni.setStorageSync("nowTable", `${this.optionsValues[this.index]}`);
				res = await this.$api.session(`${this.optionsValues[this.index]}`);
                if(res.data.touxiang) {
                    uni.setStorageSync('headportrait', res.data.touxiang);
                } else if(res.data.headportrait) {
                    uni.setStorageSync('headportrait', res.data.headportrait);
                }
				// 保存用户id
				uni.setStorageSync("userid", res.data.id);
				if(res.data.vip) {
					uni.setStorageSync("vip", res.data.vip);
				}
				uni.setStorageSync("appRole", `${this.options[this.index]}`);
				this.$utils.tab('../index/index');
			},
			optionsChange(e) {
				this.index = e.target.value
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
