function startCall() {

    const roomID = "lawsetu123";
    const userID = "user_" + Date.now();
    const userName = "User";

    // 🔥 TEST TOKEN (NO BACKEND)
    const kitToken = ZegoUIKitPrebuilt.generateKitTokenForTest(
        1697354280,  // ✅ tumhara AppID
        "aa6c2f6253f1f937c71b578f7cf1080f", // ✅ AppSign (NOT serverSecret)
        roomID,
        userID,
        userName
    );

    const zp = ZegoUIKitPrebuilt.create(kitToken);

    zp.joinRoom({
        container: document.querySelector("#videoContainer"),

        scenario: {
            mode: ZegoUIKitPrebuilt.VideoConference,
        },
    });
}

window.onload = function () {

    const savedTheme = localStorage.getItem("theme") || "light";

    document.body.classList.add(savedTheme);
}
