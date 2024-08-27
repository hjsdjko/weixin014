<template>
	<view>
		<view class="cu-chat">
			<view v-bind:key="index" v-html="logistics">
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				logistics: ''
			};
		},
		async onLoad(options) {
			if (options.id) {
				let res = await this.$api.info(`orders`, options.id);
				this.logistics = res.data.logistics;
				console.log(this.logistics)
			}
		},
		onUnload() {
		},
		methods: {
		}
	}
</script>

<style>
	page {
		padding-bottom: 100upx;
	}
</style>
