package coil3.svg

import coil3.ImageLoader
import coil3.decode.DecodeResult
import coil3.decode.Decoder
import coil3.decode.ImageSource
import coil3.fetch.SourceFetchResult
import coil3.request.Options

/**
 * A [Decoder] that uses [AndroidSVG](https://bigbadaboom.github.io/androidsvg/)
 * and [SVGDOM](https://api.skia.org/classSkSVGDOM.html/) to decode SVG
 * files.
 *
 * @param useViewBoundsAsIntrinsicSize If true, uses the SVG's view bounds as the intrinsic size for
 *  the SVG. If false, uses the SVG's width/height as the intrinsic size for the SVG.
 */
expect class SvgDecoder(
    source: ImageSource,
    options: Options,
    useViewBoundsAsIntrinsicSize: Boolean = true,
) : Decoder {
    override suspend fun decode(): DecodeResult?

    class Factory(
        useViewBoundsAsIntrinsicSize: Boolean = true,
    ) : Decoder.Factory {
        override fun create(
            result: SourceFetchResult,
            options: Options,
            imageLoader: ImageLoader,
        ): Decoder?
    }
}
