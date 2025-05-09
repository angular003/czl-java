# Changelog

## 0.1.0-alpha.1 (2025-05-09)

Full Changelog: [v0.0.1-alpha.0...v0.1.0-alpha.1](https://github.com/angular003/czl-java/compare/v0.0.1-alpha.0...v0.1.0-alpha.1)

### ⚠ BREAKING CHANGES

* **client:** extract auto pagination to shared classes
* **client:** **Migration:** - If you were referencing the `AutoPager` class on a specific `*Page` or `*PageAsync` type, then you should instead reference the shared `AutoPager` and `AutoPagerAsync` types, under the `core` package
    - `AutoPagerAsync` now has different usage. You can call `.subscribe(...)` on the returned object instead to get called back each page item. You can also call `onCompleteFuture()` to get a future that completes when all items have been processed. Finally, you can call `.close()` on the returned object to stop auto-paginating early
    - If you were referencing `getNextPage` or `getNextPageParams`:
       - Swap to `nextPage()` and `nextPageParams()`
       - Note that these both now return non-optional types (use `hasNextPage()` before calling these, since they will throw if it's impossible to get another page)
* **client:** refactor exception structure and methods ([#12](https://github.com/angular003/czl-java/issues/12))
* **client:** **Migration:** Previously you would access error JSON on an exception via `exception.error()._additionalProperties()`, which would return `Map<String, JsonValue>`. Now you would access this via `exception.body()`, which returns `JsonValue`. You should no longer assume that the returned error JSON is an object. You can check via `exception.body().asObject()`.

### Features

* **client:** add enum validation method ([10334fa](https://github.com/angular003/czl-java/commit/10334faee89baca9ae0f22bb4f5a916c59d97c2a))
* **client:** allow providing some params positionally ([98c3226](https://github.com/angular003/czl-java/commit/98c32264a8950bfd97036137425729afea7d2259))
* **client:** expose request body setter and getter ([#23](https://github.com/angular003/czl-java/issues/23)) ([f0a5e26](https://github.com/angular003/czl-java/commit/f0a5e26d91e8f6d8affb5206c03e5db133e856b2))
* **client:** extract auto pagination to shared classes ([eb2100e](https://github.com/angular003/czl-java/commit/eb2100eaf1fecd3657afdd15bdab5546af4598e5))
* **client:** make datetime deserialization more lenient ([#22](https://github.com/angular003/czl-java/issues/22)) ([0eefc73](https://github.com/angular003/czl-java/commit/0eefc73001d89c8393c06cd7b0e5a6f6e6a88b3c))
* **client:** make union deserialization more robust ([#21](https://github.com/angular003/czl-java/issues/21)) ([10334fa](https://github.com/angular003/czl-java/commit/10334faee89baca9ae0f22bb4f5a916c59d97c2a))
* **client:** support a lower jackson version ([#18](https://github.com/angular003/czl-java/issues/18)) ([92d6ca2](https://github.com/angular003/czl-java/commit/92d6ca2d48755a472d6d82cb8fa631f19319e714))
* **client:** support setting base URL via env var ([d160911](https://github.com/angular003/czl-java/commit/d16091124087269a7b21855dd9a664c6aeb6e6a5))
* **client:** throw on incompatible jackson version ([92d6ca2](https://github.com/angular003/czl-java/commit/92d6ca2d48755a472d6d82cb8fa631f19319e714))


### Bug Fixes

* **client:** bump to better jackson version ([51a0c0a](https://github.com/angular003/czl-java/commit/51a0c0a429b077d3e53e9284227662770fed6785))
* **client:** don't call `validate()` during deserialization if we don't have to ([#19](https://github.com/angular003/czl-java/issues/19)) ([62380d2](https://github.com/angular003/czl-java/commit/62380d2fcb1eceb3b2e6d180dbd2dcd99259626f))
* **client:** limit json deserialization coercion ([#20](https://github.com/angular003/czl-java/issues/20)) ([4be0130](https://github.com/angular003/czl-java/commit/4be013076893797f6b8087d78a4f814fb5fad7e8))
* **client:** return `Optional&lt;T&gt;` instead of `Optional<? extends T>` ([#26](https://github.com/angular003/czl-java/issues/26)) ([e2bff60](https://github.com/angular003/czl-java/commit/e2bff60ff043d3acb9c0fe1702e5b4acd70c00b6))
* **client:** support kotlin 1.8 runtime ([#10](https://github.com/angular003/czl-java/issues/10)) ([f4a852d](https://github.com/angular003/czl-java/commit/f4a852d115994c915f39c033565f70ccb66c1cd7))


### Performance Improvements

* **client:** cached parsed type in `HttpResponseFor` ([#24](https://github.com/angular003/czl-java/issues/24)) ([3102d5f](https://github.com/angular003/czl-java/commit/3102d5f8385932e35032397c55af03fee213e17a))
* **internal:** improve compilation+test speed ([b5ae36d](https://github.com/angular003/czl-java/commit/b5ae36debcbb6228dbe15c73578f4b56f6b731fe))


### Chores

* **ci:** add timeout thresholds for CI jobs ([b74ef3b](https://github.com/angular003/czl-java/commit/b74ef3b87fe2c696dd603e48d5743cc0f5b458d5))
* **ci:** only use depot for staging repos ([cc8444e](https://github.com/angular003/czl-java/commit/cc8444eb3ffa7fd9ed69a676246076d6e5a42441))
* **client:** refactor exception structure and methods ([#12](https://github.com/angular003/czl-java/issues/12)) ([4ef360c](https://github.com/angular003/czl-java/commit/4ef360c1a076cdff838228aad28bee2bf3055641))
* **client:** remove unnecessary json state from some query param classes ([10334fa](https://github.com/angular003/czl-java/commit/10334faee89baca9ae0f22bb4f5a916c59d97c2a))
* configure new SDK language ([7e98ddb](https://github.com/angular003/czl-java/commit/7e98ddbda813675ea0cdd5d8c8980ce7dec8da45))
* go live ([#1](https://github.com/angular003/czl-java/issues/1)) ([b4c6f0b](https://github.com/angular003/czl-java/commit/b4c6f0b47f3f720648deda4fa707206e7b5f7556))
* **internal:** add invalid json deserialization tests ([10334fa](https://github.com/angular003/czl-java/commit/10334faee89baca9ae0f22bb4f5a916c59d97c2a))
* **internal:** add json roundtripping tests ([10334fa](https://github.com/angular003/czl-java/commit/10334faee89baca9ae0f22bb4f5a916c59d97c2a))
* **internal:** codegen related update ([6f64bb1](https://github.com/angular003/czl-java/commit/6f64bb1cc56aad342663fbf25286c89c79fdd231))
* **internal:** codegen related update ([#11](https://github.com/angular003/czl-java/issues/11)) ([232d76c](https://github.com/angular003/czl-java/commit/232d76c76dc2f2805f7a03af03a85c7bb1c68b55))
* **internal:** codegen related update ([#5](https://github.com/angular003/czl-java/issues/5)) ([2d959c8](https://github.com/angular003/czl-java/commit/2d959c86e3b5dcc6069684b42b6fccae09857ad4))
* **internal:** delete duplicate tests ([c059529](https://github.com/angular003/czl-java/commit/c059529d246b74dcc07c247ac4e0b4dcee2ebcab))
* **internal:** expand CI branch coverage ([4bb26da](https://github.com/angular003/czl-java/commit/4bb26daa4981b76c9d51691afbf57e0ccfff8b52))
* **internal:** fix example formatting ([#14](https://github.com/angular003/czl-java/issues/14)) ([4896c22](https://github.com/angular003/czl-java/commit/4896c222e5b5db184d011f07826276db26ad1ea5))
* **internal:** generate more tests ([239e860](https://github.com/angular003/czl-java/commit/239e86058d092ebc320315e6dc52aa04eed719b5))
* **internal:** java 17 -&gt; 21 on ci ([3d50ae6](https://github.com/angular003/czl-java/commit/3d50ae69cf49adfc7b3261570138c0d099e30b73))
* **internal:** make multipart assertions more robust ([1e19940](https://github.com/angular003/czl-java/commit/1e19940d9e358a7d8ddd41c05065f0219116b634))
* **internal:** reduce CI branch coverage ([9d74a75](https://github.com/angular003/czl-java/commit/9d74a75ad6f3259f82b8465f97f2db5f7b017379))
* **internal:** refactor query param serialization impl and tests ([#7](https://github.com/angular003/czl-java/issues/7)) ([40f8b3e](https://github.com/angular003/czl-java/commit/40f8b3e0f71c850be926203615feedc1ceee5174))
* **internal:** refactor some test assertions ([c059529](https://github.com/angular003/czl-java/commit/c059529d246b74dcc07c247ac4e0b4dcee2ebcab))
* **internal:** reformat some tests ([#9](https://github.com/angular003/czl-java/issues/9)) ([239e860](https://github.com/angular003/czl-java/commit/239e86058d092ebc320315e6dc52aa04eed719b5))
* **internal:** remove extra empty newlines ([#3](https://github.com/angular003/czl-java/issues/3)) ([614ab09](https://github.com/angular003/czl-java/commit/614ab096fa71e8c9e3f5771ae466cad2bd8999fd))
* **internal:** remove flaky `-Xbackend-threads=0` option ([0a7be5d](https://github.com/angular003/czl-java/commit/0a7be5d261036d0fc6e84c6b571a9c8fffc2741e))
* **internal:** remove unnecessary `assertNotNull` calls ([1e19940](https://github.com/angular003/czl-java/commit/1e19940d9e358a7d8ddd41c05065f0219116b634))
* **internal:** remove unnecessary import ([#15](https://github.com/angular003/czl-java/issues/15)) ([f68204a](https://github.com/angular003/czl-java/commit/f68204ae0145a1cc82eae6eb6af1efa8ecd31413))
* **internal:** rename `getPathParam` ([#8](https://github.com/angular003/czl-java/issues/8)) ([c059529](https://github.com/angular003/czl-java/commit/c059529d246b74dcc07c247ac4e0b4dcee2ebcab))
* **internal:** reorder some params methodsc ([c059529](https://github.com/angular003/czl-java/commit/c059529d246b74dcc07c247ac4e0b4dcee2ebcab))
* **internal:** swap from `getNullable` to `getOptional` ([#25](https://github.com/angular003/czl-java/issues/25)) ([7daceed](https://github.com/angular003/czl-java/commit/7daceed4feb19e8c02d0483cf6a01904688eb03f))
* **internal:** update java toolchain ([bd3376f](https://github.com/angular003/czl-java/commit/bd3376f4b6e1e1c98da23a6a01529fb4b790a0f1))


### Documentation

* add `build` method comments ([#6](https://github.com/angular003/czl-java/issues/6)) ([537e5e1](https://github.com/angular003/czl-java/commit/537e5e1479baf0001592c3acc5795d38e20cc343))
* add comments to `JsonField` classes ([e2bff60](https://github.com/angular003/czl-java/commit/e2bff60ff043d3acb9c0fe1702e5b4acd70c00b6))
* **client:** update jackson compat error message ([7fe8902](https://github.com/angular003/czl-java/commit/7fe8902d4e92f1479c492b442ea811f1cb65c9c0))
* deduplicate and refine comments ([#4](https://github.com/angular003/czl-java/issues/4)) ([e19679e](https://github.com/angular003/czl-java/commit/e19679ea748b68a0ac155036816ceb7310738301))
* document how to forcibly omit required field ([3d6232f](https://github.com/angular003/czl-java/commit/3d6232fb617216a615561814947f10b6185355aa))
* explain http client customization ([921d891](https://github.com/angular003/czl-java/commit/921d891e09c859799c608d7a68aac5ce41a287cf))
* explain jackson compat in readme ([a8bf681](https://github.com/angular003/czl-java/commit/a8bf681e8ad2c547a954ea11bf812c7045e847a9))
* minor readme tweak ([#17](https://github.com/angular003/czl-java/issues/17)) ([856650f](https://github.com/angular003/czl-java/commit/856650f195f67c42f1ea3d72064af33440c9c58a))
* refine comments on multipart params ([#13](https://github.com/angular003/czl-java/issues/13)) ([1e19940](https://github.com/angular003/czl-java/commit/1e19940d9e358a7d8ddd41c05065f0219116b634))
* swap examples used in readme ([#27](https://github.com/angular003/czl-java/issues/27)) ([3d6232f](https://github.com/angular003/czl-java/commit/3d6232fb617216a615561814947f10b6185355aa))
* update documentation links to be more uniform ([6c2f5a7](https://github.com/angular003/czl-java/commit/6c2f5a7ef0d95c7b4cac9468337eb87ade28b855))
* update readme exception docs ([#16](https://github.com/angular003/czl-java/issues/16)) ([cf014c1](https://github.com/angular003/czl-java/commit/cf014c15136d895262f338c213a9b707f6f0e1d3))
