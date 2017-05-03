jQuery(function () {
    jQuery(".infoIcon").mouseenter(function () {
        jQuery(this).siblings(".infoBalloon").addClass("showBalloon");
    }).mouseleave(function () {
        jQuery(".infoBalloon").removeClass("showBalloon");
    });
});

