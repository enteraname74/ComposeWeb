import { instantiate } from './composeweb.uninstantiated.mjs';

await wasmSetup;

instantiate({ skia: Module['asm'] });
