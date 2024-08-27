<template>
<view class="content">
	<view class="box" :style='{"width":"100%","padding":"0 0 0 0","position":"relative","background":"#ffffff","height":"100%"}'>
		<view :style='{"width":"100%","padding":"24rpx 24rpx 24rpx 24rpx","background":"#ffffff","display":"block","height":"auto"}'>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"2rpx 2rpx 2rpx 2rpx","background":"#fdfbdc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>头像</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"2rpx 2rpx 2rpx 2rpx","background":"#fdfbdc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>用户账号</view>
				<input :style='{"border":"0px solid #cccccc","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fdfbdc","fontSize":"28rpx","height":"64rpx"}' disabled="true"  v-model="ruleForm.yonghuzhanghao" placeholder="用户账号"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"2rpx 2rpx 2rpx 2rpx","background":"#fdfbdc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>用户姓名</view>
				<input :style='{"border":"0px solid #cccccc","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fdfbdc","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.yonghuxingming" placeholder="用户姓名"></input>
			</view>
			<view v-if="tableName=='yonghu'" :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"2rpx 2rpx 2rpx 2rpx","background":"#fdfbdc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="yonghuxingbieChange" :value="yonghuxingbieIndex" :range="yonghuxingbieOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666666"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"2rpx 2rpx 2rpx 2rpx","background":"#fdfbdc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>手机号码</view>
				<input :style='{"border":"0px solid #cccccc","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fdfbdc","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.shoujihaoma" placeholder="手机号码"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"2rpx 2rpx 2rpx 2rpx","background":"#fdfbdc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shangjia'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>商家账号</view>
				<input :style='{"border":"0px solid #cccccc","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fdfbdc","fontSize":"28rpx","height":"64rpx"}' disabled="true"  v-model="ruleForm.shangjiazhanghao" placeholder="商家账号"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"2rpx 2rpx 2rpx 2rpx","background":"#fdfbdc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shangjia'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>商家名称</view>
				<input :style='{"border":"0px solid #cccccc","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fdfbdc","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.shangjiamingcheng" placeholder="商家名称"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"2rpx 2rpx 2rpx 2rpx","background":"#fdfbdc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shangjia'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>联系电话</view>
				<input :style='{"border":"0px solid #cccccc","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fdfbdc","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.lianxidianhua" placeholder="联系电话"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"2rpx 2rpx 2rpx 2rpx","background":"#fdfbdc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shangjia'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>商家地址</view>
				<input :style='{"border":"0px solid #cccccc","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fdfbdc","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.shangjiadizhi" placeholder="商家地址"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"2rpx 2rpx 2rpx 2rpx","background":"#fdfbdc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shangjia'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>联系人</view>
				<input :style='{"border":"0px solid #cccccc","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fdfbdc","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.lianxiren" placeholder="联系人"></input>
			</view>
			<view :style='{"width":"100%","margin":"40rpx 0 0 0","justifyContent":"center","display":"flex","height":"auto"}' class="btn">
				<button @tap="update()" class="cu-btn lg" :style='{"border":"0","padding":"0 0 0 0","margin":"0 20rpx 0 20rpx","color":"#333333","borderRadius":"8rpx","background":"#fff000","width":"240rpx","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}'>保存</button>
				<button @tap="logout()" class="cu-btn lg" :style='{"border":"0","padding":"0 0 0 0","margin":"0 20rpx 0 20rpx","color":"#fff","borderRadius":"8rpx","background":"#ff746d","width":"240rpx","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}'>退出登录</button>
			</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				ruleForm: {
				},
				tableName:"",
				yonghuxingbieOptions: [],
				yonghuxingbieIndex: 0,
			}
		},
        components: {
            multipleSelect
        },
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onLoad() {
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.ruleForm = res.data;
			this.tableName = table;
			// 自定义下拉框值
			if(this.tableName=='yonghu'){
				this.yonghuxingbieOptions = "男,女".split(',');
				this.yonghuxingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.yonghuxingbieIndex = index;
					}
				});
			}
			this.styleChange()
            this.$forceUpdate()
		},
		methods: {
			yonghutouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'file/' + res.file;
					_this.$forceUpdate();
				});
			},
            // 下拉变化
            yonghuxingbieChange(e) {
                    this.yonghuxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.yonghuxingbieOptions[this.yonghuxingbieIndex]
            },

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					document.querySelectorAll('.radioText').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#666666"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.radioTextActive').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#333"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.checkText').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#666666"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.checkTextActive').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#333"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-radio-input').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #999999","borderRadius":"100%","background":"#ffffff"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-radio-input-checked').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #ffb400","borderRadius":"100%","color":"#666","background":"#fff000"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-checkbox-input').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #999999","borderRadius":"100%","background":"#ffffff"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-checkbox-input-checked').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #ffb400","color":"#666","borderRadius":"100%","background":"#fff000"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			logout() {
				uni.clearStorageSync()
				uni.reLaunch({
					url:'/pages/index/index'
				})
			},
			
			// 注册
			async update() {
				if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
					this.$utils.msg(`用户账号不能为空`);
					return
				}
				if((!this.ruleForm.yonghumima) && `yonghu` == this.tableName){
					this.$utils.msg(`用户密码不能为空`);
					return
				}
				if((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName){
					this.$utils.msg(`用户姓名不能为空`);
					return
				}
				if(`yonghu` == this.tableName && this.ruleForm.shoujihaoma&&(!this.$validate.isMobile(this.ruleForm.shoujihaoma))){
					this.$utils.msg(`手机号码应输入手机格式`);
					return
				}
				if(`yonghu` == this.tableName && this.ruleForm.money&&(!this.$validate.isNumber(this.ruleForm.money))){
					this.$utils.msg(`余额应输入数字`);
					return
				}
				if((!this.ruleForm.shangjiazhanghao) && `shangjia` == this.tableName){
					this.$utils.msg(`商家账号不能为空`);
					return
				}
				if((!this.ruleForm.shangjiamima) && `shangjia` == this.tableName){
					this.$utils.msg(`商家密码不能为空`);
					return
				}
				if((!this.ruleForm.shangjiamingcheng) && `shangjia` == this.tableName){
					this.$utils.msg(`商家名称不能为空`);
					return
				}
				if(`shangjia` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isPhone(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入电话格式`);
					return
				}
				let table = uni.getStorageSync("nowTable");
				await this.$api.update(table, this.ruleForm);
				this.$utils.msgBack('修改成功');;
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
