<template>
	<view class="container">
		<radio-group>
			<view class="pay-type-content">
                <!-- #ifdef APP-PLUS -->
                <view class="pay-type-item">
                    <img class="pay-icon" mode="heightFix" src="static/pay-confirm/weixin.png" alt>
                    <radio label="微信支付" checked="true" value="1" ></radio>
                </view>
                <view class="pay-type-item">
                    <img class="pay-icon" mode="heightFix" src="static/pay-confirm/zhifubao.png" alt>
                    <radio label="支付宝支付" value="2" ></radio>
                </view>
                <view class="pay-type-item">
                    <img class="pay-icon" mode="heightFix" src="static/pay-confirm/jianshe.png" alt>
                    <radio label="建设银行"  value="3" ></radio>
                </view>
                <view class="pay-type-item">
                    <img class="pay-icon" mode="heightFix" src="static/pay-confirm/nongye.png" alt>
                    <radio label="农业银行"  value="4" ></radio>
                </view>
                <view class="pay-type-item">
                    <img class="pay-icon" mode="heightFix" src="static/pay-confirm/zhongguo.png" alt>
                    <radio label="中国银行" value="5" ></radio>
                </view>
                <view class="pay-type-item">
                    <img class="pay-icon" mode="heightFix" src="static/pay-confirm/jiaotong.png" alt>
                    <radio label="交通银行" value="6"></radio>
                </view>
                <!-- #endif -->
                
                <!-- #ifndef APP-PLUS -->
                <view class="pay-type-item">
                    <img class="pay-icon" mode="heightFix" src="../../static/pay-confirm/weixin.png" alt>
                    <radio label="微信支付" checked="true" value="1" ></radio>
                </view>
                <view class="pay-type-item">
                    <img class="pay-icon" mode="heightFix" src="../../static/pay-confirm/zhifubao.png" alt>
                    <radio label="支付宝支付" value="2" ></radio>
                </view>
                <view class="pay-type-item">
                    <img class="pay-icon" mode="heightFix" src="../../static/pay-confirm/jianshe.png" alt>
                    <radio label="建设银行"  value="3" ></radio>
                </view>
                <view class="pay-type-item">
                    <img class="pay-icon" mode="heightFix" src="../../static/pay-confirm/nongye.png" alt>
                    <radio label="农业银行"  value="4" ></radio>
                </view>
                <view class="pay-type-item">
                    <img class="pay-icon" mode="heightFix" src="../../static/pay-confirm/zhongguo.png" alt>
                    <radio label="中国银行" value="5" ></radio>
                </view>
                <view class="pay-type-item">
                    <img class="pay-icon" mode="heightFix" src="../../static/pay-confirm/jiaotong.png" alt>
                    <radio label="交通银行" value="6"></radio>
                </view>
                <!-- #endif -->

			</view>
			<view class="buton-content">
				<button @tap="onPageTap('recharge')" class="bg-red margin-tb-sm">确定</button>
			</view>
		</radio-group>
	</view>
</template>
<script>
	export default {
		data() {
			return {
			}
		},
		mounted() {
		},
		methods: {
			onPageTap(url) {
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			}
		}
	};
</script>
<style lang="scss" scoped>
	.pay-icon{
        width:100%;
		height:128rpx;
	}
	
	.container {
		margin: 10px;
		font-size: 14px;

		.top-content {
			display: flex;
			align-items: center;
			padding: 20upx;
		}

		.price-content {
			display: flex;
			align-items: center;
			margin-top: 20upx;
			padding-bottom: 20px;
			padding: 20upx;
			border-bottom: 1upx solid #eeeeee;
			font-size: 20upx;
			font-weight: bold;
			color: red;
		}

		.pay-type-content {
			display: flex;
			align-items: center;
			margin-top: 20upx;
			flex-wrap: wrap;

			.pay-type-item {
				display: flex;
				align-items: center;
				justify-content: space-between;
				width: 100%;
				border: 1upx solid #eeeeee;
				padding: 20upx;
				background: #FFFFFF;
			}
		}

		.buton-content {
			margin: 20upx;
		}
	}
</style>
